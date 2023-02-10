package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.CasesDTO;
import br.ueg.modelo.application.model.Cases;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class CasesMapperImpl implements CasesMapper {

    @Override
    public CasesDTO toDTO(Cases cases) {
        if ( cases == null ) {
            return null;
        }

        CasesDTO casesDTO = new CasesDTO();

        casesDTO.setId( cases.getId() );
        casesDTO.setName( cases.getName() );
        casesDTO.setGender( cases.getGender() );
        if ( cases.getCpf() != null ) {
            casesDTO.setCpf( cases.getCpf() );
        }
        casesDTO.setAddress( cases.getAddress() );
        casesDTO.setCity( cases.getCity() );
        casesDTO.setCountry( cases.getCountry() );
        casesDTO.setStatus( cases.getStatus() );
        casesDTO.setUpdated( cases.getUpdated() );

        return casesDTO;
    }

    @Override
    public Cases toEntity(CasesDTO casesDTO) {
        if ( casesDTO == null ) {
            return null;
        }

        Cases cases = new Cases();

        cases.setId( casesDTO.getId() );
        cases.setName( casesDTO.getName() );
        cases.setGender( casesDTO.getGender() );
        cases.setCpf( casesDTO.getCpf() );
        cases.setAddress( casesDTO.getAddress() );
        cases.setCity( casesDTO.getCity() );
        cases.setCountry( casesDTO.getCountry() );
        cases.setStatus( casesDTO.getStatus() );
        cases.setUpdated( casesDTO.getUpdated() );

        return cases;
    }
}
