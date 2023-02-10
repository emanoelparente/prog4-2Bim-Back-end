package br.ueg.modelo.application.service;

import br.ueg.modelo.application.enums.StatusSimNao;
import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Amigo;
import br.ueg.modelo.application.model.Cases;
import br.ueg.modelo.application.repository.CasesRepository;
import br.ueg.modelo.comum.exception.BusinessException;
import br.ueg.modelo.comum.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CasesService extends GenericCrudService<Cases, Long> {


    @Autowired
    private CasesRepository casesRepository;

    @Override
    public JpaRepository getRepository() {
        return casesRepository;
    }


    protected void inicializarModelParaInclusao(Cases cases){
        cases.setUpdated(LocalDate.now().toString());
    }



    /**
     * Verifica se os Campos Obrigatórios foram preenchidos.
     *
     * @param cases
     */
    public void validarCamposObrigatorios(final Cases cases) {
        boolean vazio = Boolean.FALSE;

        if (Util.isEmpty(cases.getName())) {
            vazio = Boolean.TRUE;
        }

        if (vazio) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }

    /**
     * Verifica se o TipoAmigo a ser salvo já existe na base de dados.
     *
     * @param cases
     */
    public void validarDuplicidade(final Cases cases) {
//        Long count = casesRepository.countByNomeAndNotId(amigo.getNome(), amigo.getId());
//
//        if (count > BigDecimal.ZERO.longValue()) {
//            throw new BusinessException(SistemaMessageCode.ERRO_AMIGO_DUPLICADO);
//        }
    }

}
