package com.tima.admin.scheduled;

import com.tima.admin.service.impl.RecommendedCodeServiceImpl;
import com.tima.admin.service.impl.SendMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zwh
 * 所有定时任务在这里统一管理，定时任务名称一定要不同，否则集群会出问题
 */
@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    private RecommendedCodeServiceImpl recommendedCodeService;

    @Autowired
    private SendMessageServiceImpl sendMessageService;

    @Scheduled(fixedRate = 3000000)
    public void addRedis() {
        log.info("结束加数据到redis");
    }


    /**
     * 每年一月一号凌晨重置推荐码使用次数
     */
    @Scheduled(cron = "0 0 0 1 1 ? ")  //每年一月一号凌晨
    public void resetCode() {

        recommendedCodeService.resetCode();
    }

//    /**
//     * @Description: 用户注册周年推送消息  每天凌晨0点执行
//     * @Author: YYF
//     * @CreateDate: 2018/12/11 13:46
//     * @Version: 1.0
//     */
//    @Scheduled(cron = "0 0 0 * * ? ")
//    public void anniversaryBlessing() {
//        sendMessageService.sendAnniversaryBlessing();
//    }


}
