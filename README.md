StockFlow

A REST API for managing inventory across 
multiple warehouses for B2B businesses.

What it does
- Tracks products across multiple warehouses
- Alerts when stock is running low
- Manages supplier information

Tech Used
- Java + Spring Boot
- MongoDB

Setup
1. Clone this repo
2. Start MongoDB on your machine
3. Run the project using IntelliJ
4. API runs on port 8082

API
GET /api/companies/{company_id}/alerts/low-stock

Returns list of products that are 
below minimum stock level in any warehouse.

Example Response
{
  "alerts": [
    {
      "productName": "Laptop",
      "currentStock": 3,
      "threshold": 10,
      "warehouseName": "Delhi Warehouse"
    }
  ],
  "total_alerts": 1
}
