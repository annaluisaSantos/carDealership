package com.cardealership.dto;


import org.springframework.hateoas.RepresentationModel;

public class StandDTO extends RepresentationModel<StandDTO> {

    private Long StandIdDTO;
    private String nameDTO;
    private int phoneNumberDTO;
    private String emailDTO;

    public StandDTO(Long standIdDTO, String nameDTO, int phoneNumberDTO, String emailDTO) {
        StandIdDTO = standIdDTO;
        this.nameDTO = nameDTO;
        this.phoneNumberDTO = phoneNumberDTO;
        this.emailDTO = emailDTO;
    }

    public Long getStandIdDTO() {
        return StandIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public int getPhoneNumberDTO() {
        return phoneNumberDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setStandIdDTO(Long standIdDTO) {
        StandIdDTO = standIdDTO;
    }

    public void setName(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setPhoneNumberDTO(int phoneNumberDTO) {
        this.phoneNumberDTO = phoneNumberDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }
}
