package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.AmigoDTO;
import br.ueg.modelo.application.model.Amigo;
import br.ueg.modelo.application.model.TipoAmigo;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class AmigoMapperImpl implements AmigoMapper {

    @Autowired
    private SimNaoMapper simNaoMapper;

    @Override
    public AmigoDTO toDTO(Amigo amigo) {
        if ( amigo == null ) {
            return null;
        }

        AmigoDTO amigoDTO = new AmigoDTO();

        amigoDTO.setNomeTipoAmigo( amigoTipoNome( amigo ) );
        amigoDTO.setIdTipoAmigo( amigoTipoId( amigo ) );
        amigoDTO.setId( amigo.getId() );
        amigoDTO.setNome( amigo.getNome() );
        amigoDTO.setDataAmizade( amigo.getDataAmizade() );
        amigoDTO.setAmigo( simNaoMapper.asBoolean( amigo.getAmigo() ) );

        return amigoDTO;
    }

    @Override
    public Amigo toEntity(AmigoDTO amigoDTO) {
        if ( amigoDTO == null ) {
            return null;
        }

        Amigo amigo = new Amigo();

        amigo.setTipo( amigoDTOToTipoAmigo( amigoDTO ) );
        amigo.setId( amigoDTO.getId() );
        amigo.setNome( amigoDTO.getNome() );
        amigo.setDataAmizade( amigoDTO.getDataAmizade() );
        if ( amigoDTO.getAmigo() != null ) {
            amigo.setAmigo( simNaoMapper.asStatusSimNao( amigoDTO.getAmigo().booleanValue() ) );
        }

        return amigo;
    }

    private String amigoTipoNome(Amigo amigo) {
        if ( amigo == null ) {
            return null;
        }
        TipoAmigo tipo = amigo.getTipo();
        if ( tipo == null ) {
            return null;
        }
        String nome = tipo.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private Long amigoTipoId(Amigo amigo) {
        if ( amigo == null ) {
            return null;
        }
        TipoAmigo tipo = amigo.getTipo();
        if ( tipo == null ) {
            return null;
        }
        Long id = tipo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected TipoAmigo amigoDTOToTipoAmigo(AmigoDTO amigoDTO) {
        if ( amigoDTO == null ) {
            return null;
        }

        TipoAmigo tipoAmigo = new TipoAmigo();

        tipoAmigo.setId( amigoDTO.getIdTipoAmigo() );

        return tipoAmigo;
    }
}
