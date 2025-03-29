package uit.advancecrm.group17.bpmn.process;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;

@Slf4j
public abstract class BaseProcessService {
    protected ProcessEngine processEngine;
    protected FormService formService;
    protected TaskService taskService;
    protected ManagementService managementService;
    protected RuntimeService runtimeService;
    protected HistoryService processEngineHistoryService;

    public BaseProcessService(ProcessEngineFactoryBean processEngineFactoryBean) throws Exception {
        processEngine = processEngineFactoryBean.getObject();

        formService = processEngine.getFormService();
        taskService= processEngine.getTaskService();
        managementService = processEngine.getManagementService();
        runtimeService =processEngine.getRuntimeService();
        processEngineHistoryService = processEngine.getHistoryService();

    }
}
