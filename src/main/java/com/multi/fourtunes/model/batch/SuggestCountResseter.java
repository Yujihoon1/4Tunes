package com.multi.fourtunes.model.batch;

import com.multi.fourtunes.model.biz.AnalysisBiz;
import com.multi.fourtunes.model.biz.SuggestBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SuggestCountResseter {

    @Autowired
    SuggestBiz suggestBiz;
    @Autowired
    AnalysisBiz analysisBiz;
    

    // 매월 1일 0시 0분 실행
    @Scheduled(cron = "0 0 0 1 * ?")
    public void executeTask() {
        System.out.println("모든 유저의 SuggestCount 를 초기화합니다. ");

        suggestBiz.seggestCountReset();
    }
    
    // 5분 마다
    @Scheduled(cron = "0 0/5 * * * ?")
    public void updateSongAiKeywordTask() {
    	System.out.println("NULL 값인 Aikeyword를 다시 추천 받습니다. ");
    	analysisBiz.updateSongAiKeyword();
    }
}

