package br.ueg.modelo.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Entidade de transferência de Cases")
public @Data
class CasesDTO implements Serializable {

    @ApiModelProperty(value = "id of case")
    private Long id;

    @ApiModelProperty(value = "Name of case")
    private String name;

    @ApiModelProperty(value = "gender of case")
    private String gender;

    @ApiModelProperty(value = "cpf of case")
    private int cpf;

    @ApiModelProperty(value = "address of case")
    private String address;

    @ApiModelProperty(value = "city of case")
    private String city;

    @ApiModelProperty(value = "country of case")
    private String country;

    @ApiModelProperty(value = "status of case")
    private String status;

    @ApiModelProperty(value = "updated of case")
    private String updated;

}
