package app.nanaBank.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 * @author Jonathan
 */
@MappedSuperclass
@Getter
@Setter
@ToString
/*
 * @EntityListeners is used to register the auditing entity listener
 * AuditingEntityListener.class is a built-in listener that automatically populates auditing fields
 * @MappedSuperclass indicates that this class is a base class for other entities
 */
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
    
}
