package uit.advancecrm.group17.bpmn.process;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Repository
public class SampleProcessService extends BaseProcessService {

    public SampleProcessService(ProcessEngineFactoryBean processEngineFactoryBean) throws Exception {
        super(processEngineFactoryBean);

        log.info("start processEngine BEAN SUCCESS!!!{}", processEngine);
        log.info("start formService BEAN SUCCESS!!!{}", formService);
        log.info("start taskService BEAN SUCCESS!!!{}", taskService);
        log.info("start managementService BEAN SUCCESS!!!{}", managementService);
        log.info("start runtimeService BEAN SUCCESS!!!{}", runtimeService);
        log.info("start processEngineHistoryService BEAN SUCCESS!!!{}", processEngineHistoryService);

    }
}
