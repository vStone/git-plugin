package hudson.plugins.git;

import hudson.Extension;
import hudson.model.User;
import hudson.tasks.Mailer;
import java.util.Map;

@Extension
public class UserEmailResolver extends User.CanonicalIdResolver {

  @Override
  public String resolveCanonicalId(String email, Map<String, ?> context) {
    for (User user : User.getAll()) {
      if (email.equals(user.getProperty(Mailer.UserProperty.class).getAddress())) {
        return user.getId();
      }
    }
    return null;
  }

  @Override
  public int getPriority() {
    return -1; // lower than default.
  }

}
