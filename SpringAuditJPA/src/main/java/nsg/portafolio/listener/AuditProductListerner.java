package nsg.portafolio.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import nsg.portafolio.entity.History;
import nsg.portafolio.entity.Product;
import nsg.portafolio.repository.HistoryRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @__(
        @Lazy))
public class AuditProductListerner {

    private final HistoryRepository historyRepository;

//    @Lazy
//    public AuditProductListerner(HistoryRepository historyRepository) {
//        this.historyRepository = historyRepository;
//    }
    @PrePersist
    private void prePersist(Product product) {
        this.historyRepository.save(this.settingDate(product, "INSERT"));
    }

    @PreUpdate
    private void preUpdate(Product product) {
        this.historyRepository.save(this.settingDate(product, "UPDATE"));
    }

    @PreRemove
    private void preRemove(Product product) {
        this.historyRepository.save(this.settingDate(product, "DELETE"));
    }

    private History settingDate(Product product, String operation) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        History h = new History();
        h.setName(product.getName());
        h.setDate(LocalDateTime.now());
        h.setOperation(operation);
        h.setUser(user);

        return h;
    }

}
