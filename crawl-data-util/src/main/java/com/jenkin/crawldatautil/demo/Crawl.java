package com.jenkin.crawldatautil.demo;

import ch.qos.logback.classic.Level;
import com.google.common.io.Files;
import com.overzealous.remark.Remark;
import ch.qos.logback.classic.Logger;
import com.overzealous.remark.util.MarkdownTable;
import org.apache.commons.collections.MapUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/14 10:17
 * @description：    面试题爬取
 * @modified By：
 * @version: 1.0
 */
public class Crawl implements PageProcessor {

    private static final String QUESTION_TYPE="http://127.0.0.1:8080/face/questions/question-types/addQuestion";
    private static final String QUESTION="http://127.0.0.1:8080/face/questions/addQuestionsBatch";

    /**
     * 去除HTML标签的正则式
     */
    private static final String NO_TAG="<[.[^>]]*>";
    //设置重试次数和休眠时间以及超时时间
    private Site site = new Site().setRetryTimes(3).setSleepTime(1000).setTimeOut(20000);
    public static void main(String[] args){

        Set<String> loggers = new HashSet<>(Arrays.asList("org.apache.http","us.codecraft.webmagic"));
        for (String log : loggers) {
            Logger logger = (Logger) LoggerFactory.getLogger(log);
            logger.setLevel(Level.INFO);
            logger.setAdditive(false);
        }
            Spider.create(new Crawl())
                .addUrl("http://www.javanav.com/interview/36a24fa3258e45c89873f474ce914912.html").run();

    }

    @Override
    public void process(Page page) {
//        Html html = page.getHtml();
        Html html = page.getHtml();
        Document document = html.getDocument();
//        document.body().getElementsByClass()

//        System.out.println(html.get());
        Elements parentList  = document.getElementsByClass("tree").first().getElementsByTag("ul").first().children();
        System.out.println(parentList.size());
        //分类列表
//        Elements parentLi = document.getElementsByClass("parent_li");
        for (Element parent : parentList) {

            //获取题目列表
            Elements badge  = parent.getElementsByClass("badge");
            System.out.println(badge.size());
            //生成分类
            Integer id = generateClass(parent);

           //遍历生成题目答案
            int index = 0;
            List<Questions>  questionsList = new ArrayList<>();
            for (Element element : badge) {
                String title = element.text();
                String answer = getQuestionAnswerDetail(element);
                Questions questions = new Questions();
                questions.setFaceTitle(title);
                questions.setFaceContent(title);
                questions.setFaceStandardAnswer(answer);
                questions.setFaceSeqNumber(++index);
                questions.setFaceTypeFirst(1);
                questions.setFaceTypeSecond(2);
                questions.setFaceTypeThird(id);
                System.out.println(questions);
                questionsList.add(questions);
            }
            CommonUtils.postUrl(QUESTION,questionsList,Map.class);
        }

    }

    private String getQuestionAnswerDetail(Element element) {
        final String[] answer = {null};
        Spider.create(new PageProcessor() {

            @Override
            public void process(Page page) {
                Html html = page.getHtml();
                Document document = html.getDocument();
                Elements detail = document.getElementsByClass("interview_detail");
                Element last = detail.last();
                answer[0] = getAnwser(last);
            }

            @Override
            public Site getSite() {
                return site;
            }
        }).addUrl("http://www.javanav.com/interview/"+element.id()+".html").run();
        return answer[0];
    }

    private Integer generateClass(Element parent) {
        Elements span = parent.getElementsByTag("span");
        String text = span.first().text();
        QuestionTypes questionTypes = new QuestionTypes();
        questionTypes.setFaceQuestionTypeName(text);
        questionTypes.setFaceQuestionTypeLevel(3);
        questionTypes.setParentId(2);
        System.out.println(questionTypes);
        //TODO
        Map result = CommonUtils.postUrl(QUESTION_TYPE, questionTypes, Map.class);
        if (MapUtils.isNotEmpty(result)) {
            Object data = result.get("data");
            questionTypes.setId(Integer.parseInt(String.valueOf(data)));
        }else{
            throw new RuntimeException("分类添加失败："+text);
        }
        return questionTypes.getId();
    }

    private String getAnwser(Element last) {


        //解析图片
        Elements img = last.getElementsByTag("img");
        if (!img.isEmpty()) {
            Iterator<Element> iterator = img.iterator();
            while(iterator.hasNext()){
                Element element = iterator.next();
                String newName = UUID.randomUUID().toString();
                String src = element.attr("src");
                if(!src.startsWith("http")){
                    iterator.remove();
                    continue;
                }

                File file = CommonUtils.downLoadFileFromUrl(src, null,
                        "D:\\IdeaWorkspace\\online-face\\crawl-data-util\\src\\main\\resources\\download\\"+
                                newName +".png");
                //上传图片
                String code = CommonUtils.uploadFile(file, "http://119.29.175.198:8085/attachment/upload");
                System.out.println(src+"获取图片"+file);

                element.attr("src",
                        "http://119.29.175.198:8085/attachment/download?fileCode="+code);

            }
        }

        //获取答案
        String lastHtml = last.html();

        //解析成为markDown语法
        Remark remark = new Remark();
        lastHtml = remark.convert(lastHtml);
        //去除剩余标签
        lastHtml = lastHtml.replaceAll(NO_TAG,"");
        //去除&nbsp;
        lastHtml = lastHtml.replaceAll("&nbsp;","");

//        System.out.println(lastHtml);
        return lastHtml;
    }

    @Override
    public Site getSite() {
        return site;
    }
}
