package dolpi.StockFlow.Controller;

import dolpi.StockFlow.DTO.AlertDTO;
import dolpi.StockFlow.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/{company_id}/alerts/low-stock")
    public ResponseEntity<?> getLowStockAlerts(
            @PathVariable String company_id) {

        // Validation
        if (company_id == null ||
                company_id.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Company ID required");
        }

        // Alerts lo
        List<AlertDTO> alerts =
                alertService
                        .getLowStockAlerts(company_id);

        // Send Respnse
        return ResponseEntity.ok(
                Map.of(
                        "alerts", alerts,
                        "total_alerts", alerts.size()
                )
        );
    }
}
