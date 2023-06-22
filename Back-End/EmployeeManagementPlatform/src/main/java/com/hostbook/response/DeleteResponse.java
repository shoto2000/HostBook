package com.hostbook.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteResponse {

    private String deleteType;
    private String message = deleteType+" Deleted Successfully";

    public DeleteResponse(String deleteType)
    {
        this.deleteType = deleteType;
    }

}