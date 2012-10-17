/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hudson.plugins.git;

import hudson.model.User;
import hudson.tasks.Mailer.UserProperty;
import java.util.Map;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.jvnet.hudson.test.HudsonTestCase;

/**
 *
 * @author Jan Vansteenkiste <jan@vstone.eu>
 */
public class UserEmailResolverTest extends HudsonTestCase {
    
    public UserEmailResolverTest(String testName) {
        super(testName);
    }
   
    /**
     * Test of resolveCanonicalId method, of class UserEmailResolver.
     */
    public void testResolveCanonicalId() throws Exception {
        System.out.println("resolveCanonicalId");
        User user = User.get("foo");
        user.addProperty(new UserProperty("user@example.com"));
        user = User.get("user@example.com");
       
        Assert.assertEquals(user.getId(), "foo");
    }

}
