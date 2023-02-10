package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.TipoAmigoDTO;
import br.ueg.modelo.application.model.TipoAmigo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class TipoAmigoMapperImpl implements TipoAmigoMapper {

    @Override
    public TipoAmigoDTO toDTO(TipoAmigo tipoAmigo) {
        if ( tipoAmigo == null ) {
            return null;
        }

        TipoAmigoDTO tipoAmigoDTO = new TipoAmigoDTO();

        tipoAmigoDTO.setId( tipoAmigo.getId() );
        tipoAmigoDTO.setNome( tipoAmigo.getNome() );

        return tipoAmigoDTO;
    }

    @Override
    public TipoAmigo toEntity(TipoAmigoDTO tipoAmigoDTO) {
        if ( tipoAmigoDTO == null ) {
            return null;
        }

        TipoAmigo tipoAmigo = new TipoAmigo();

        tipoAmigo.setId( tipoAmigoDTO.getId() );
        tipoAmigo.setNome( tipoAmigoDTO.getNome() );

        return tipoAmigo;
    }
}
