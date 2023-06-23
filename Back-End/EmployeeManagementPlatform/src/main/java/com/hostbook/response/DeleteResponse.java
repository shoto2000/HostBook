package com.hostbook.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteResponse {

    private String message = "Deleted Successfully";

    public DeleteResponse(String deleteType)
    {
        this.message = deleteType +" "+ this.message;
    }

}