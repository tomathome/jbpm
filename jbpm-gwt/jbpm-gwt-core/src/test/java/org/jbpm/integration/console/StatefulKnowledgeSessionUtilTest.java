package org.jbpm.integration.console;

import org.drools.runtime.StatefulKnowledgeSession;
import org.jbpm.integration.JbpmTestCase;
import org.junit.Ignore;
import org.junit.Test;

public class StatefulKnowledgeSessionUtilTest extends JbpmTestCase {

    @Test
    public void generalTest() { 
        StatefulKnowledgeSession origKsession = StatefulKnowledgeSessionUtil.getStatefulKnowledgeSession();  
        int origKsessionId = origKsession.getId();
        assertTrue(origKsessionId > 0);
        
        StatefulKnowledgeSession newKsession = StatefulKnowledgeSessionUtil.getStatefulKnowledgeSession();
        assertTrue(newKsession == origKsession);
        assertTrue(origKsessionId == newKsession.getId());

        // test that origKsession has been disposed?
    }
    
    @Test
    @Ignore
    public void multiThreadedCommandDelegateTest() { 
        // two threads:
        // - one starts a process
        // - after which two starts a process
        // - one's process stops/finishes (and tx commits, committing sessionInfo
        // - after which two's process also stop/finishes ( and tx commits, commiting session.. )
    }
    
}
