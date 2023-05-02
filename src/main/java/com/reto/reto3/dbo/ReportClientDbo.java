package com.reto.reto3.dbo;

import com.reto.reto3.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportClientDbo {
    private Integer total;
    private ClientModel client;
}
