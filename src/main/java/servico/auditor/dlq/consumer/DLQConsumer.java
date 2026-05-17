package servico.auditor.dlq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import servico.auditor.dlq.dto.EventoOrdemDTO;
import servico.auditor.dlq.service.AuditoriaService;

@Component
public class DLQConsumer {

    @Autowired
    private AuditoriaService auditoriaService;

    private final ObjectMapper mapper = new ObjectMapper();

    @SqsListener(value = "T04N_GUSTAVO_MIRANDA_DOS_SANTOS_DLQ.fifo")
    public void receberMensagem(String mensagem, Acknowledgement ack) {

        try {

            System.out.println("Mensagem recebida da DLQ:");
            System.out.println(mensagem);

            EventoOrdemDTO evento
                    = mapper.readValue(mensagem, EventoOrdemDTO.class);

            auditoriaService.salvar(mensagem, evento);

            ack.acknowledge();

            System.out.println("Mensagem salva no banco.");

        } catch (Exception e) {

            System.out.println("Erro ao processar mensagem:");
            e.printStackTrace();
        }
    }
}
