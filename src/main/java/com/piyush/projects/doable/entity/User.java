package com.piyush.projects.doable.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String password;
    String name;

    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt; //soft delete
}
