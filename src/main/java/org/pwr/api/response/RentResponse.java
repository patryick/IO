package org.pwr.api.response;

import org.pwr.dataaccess.entity.Cassette;

import java.util.List;

public class RentResponse {
    private List<Cassette> cassetteList;
    private String info;

    public RentResponse() {
    }

    public RentResponse(List<Cassette> cassette, String info) {
        this.cassetteList = cassette;
        this.info = info;
    }

    public List<Cassette> getCassetteList() {
        return cassetteList;
    }

    public void setCassetteList(List<Cassette> cassetteList) {
        this.cassetteList = cassetteList;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "RentResponse{" + "cassetteList=" + cassetteList + ", info='" + info + '\'' + '}';
    }
}
