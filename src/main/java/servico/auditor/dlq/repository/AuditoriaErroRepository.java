package servico.auditor.dlq.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import servico.auditor.dlq.entity.AuditoriaEntity;

public interface AuditoriaErroRepository extends JpaRepository<AuditoriaEntity, UUID> {

}
