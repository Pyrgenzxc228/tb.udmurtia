package ru.udmurtia.tb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.udmurtia.tb.model.Cluster;
public interface ClusterRepository extends JpaRepository<Cluster, Long> {}