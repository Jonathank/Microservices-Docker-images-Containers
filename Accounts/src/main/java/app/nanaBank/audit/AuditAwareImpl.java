/**
 * 
 */
package app.nanaBank.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author JONATHAN
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
	
	return Optional.of("System"); // Replace with actual logic to get the current user
    }

}
