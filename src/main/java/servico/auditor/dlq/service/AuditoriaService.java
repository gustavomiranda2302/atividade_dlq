package servico.auditor.dlq.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import servico.auditor.dlq.dto.EventoOrdemDTO;
import servico.auditor.dlq.dto.ItensDTO;
import servico.auditor.dlq.entity.AuditoriaEntity;
import servico.auditor.dlq.repository.AuditoriaErroRepository;

@Service
public class AuditoriaService {

    @Autowired
    private final AuditoriaErroRepository repo;

    public AuditoriaService(AuditoriaErroRepository repo) {
        this.repo = repo;
    }

    public void salvar(String payload, EventoOrdemDTO evento) {

        int total = 0;

        for (ItensDTO item : evento.getOrderItems()) {
            total += item.getAmount();
        }

        String severidade = calcularSeveridade(total);

        AuditoriaEntity entity = new AuditoriaEntity();

        entity.setIdErro(UUID.randomUUID());
        entity.setNomeFila("T04N_GUSTAVO_MIRANDA_DOS_SANTOS_DLQ.fifo");
        entity.setPayload(payload);
        entity.setTimestamp(Instant.now());
        entity.setStatus("PENDING_ANALYSIS");
        entity.setSeverity(severidade);

        repo.save(entity);

        System.out.println("Registro salvo com severidade: " + severidade);
    }

    private String calcularSeveridade(int total) {

        if (total > 100) {
            return "HIGH";
        } else if (total >= 50) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
