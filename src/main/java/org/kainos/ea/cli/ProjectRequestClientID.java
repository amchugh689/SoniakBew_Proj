package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequestClientID {
    private int Client_ID;
    public int getClient_ID() {return Client_ID;}
    public void setClient_ID(int client_ID) {Client_ID = client_ID;}

    @JsonCreator
    public void ProjectRequestClient(
            //at JSON key "test" accept value x
            // @JsonProperty("test") int x
            //eg "test" : x
            @JsonProperty("Client_ID") int Client_ID
    ){
        this.Client_ID = Client_ID;
    }
}
