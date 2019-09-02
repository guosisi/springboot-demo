package com.hshbic.ai.common.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EsHandlerConfiguration implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

  /*  private static  final Logger logger = LoggerFactory.getLogger(EsHandlerConfiguration.class);
    private    ESHandlerInterface idd;

    @Value("${es.path}")
    private String esPath ;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("****************************** es 配置文件路径 ==>"+ esPath);
            idd = new KnowledgeManagementInterface(esPath);
        } catch (Exception e) {
            logger.error("****************************** load project.properties fail", e);
        }
    }

    public ESHandlerInterface getIdd(){
        if(idd == null) {
            try {
                run(new String[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idd;
    }
*/


}
