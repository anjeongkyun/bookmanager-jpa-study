package com.jkan.jpa.bookmanager.domain;

import com.jkan.jpa.bookmanager.domain.listener.Auditable;
import com.jkan.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//nonnull or final이 없으면 noArg와 똑같다.
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@EntityListeners(value = {UserEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Users extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

}
