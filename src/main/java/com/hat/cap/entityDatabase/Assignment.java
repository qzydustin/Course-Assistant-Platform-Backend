package com.hat.cap.entityDatabase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private Course course;
    @Column(nullable = false)
    private String title;
    @Column
    private String content;
    @Column
    private String filePath;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
}
