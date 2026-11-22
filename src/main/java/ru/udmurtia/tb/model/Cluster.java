package ru.udmurtia.tb.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cluster")
public class Cluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Пустой конструктор обязателен для JPA
    public Cluster() {}

    public Cluster(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cluster cluster = (Cluster) o;
        return Objects.equals(id, cluster.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
