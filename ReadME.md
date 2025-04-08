# Following is the Trade Analytics Micro Service(TAM) 

# API END Points: localhost:8080/
             GET All Trading Information : api/trades
             GET Information about  a specific Stock : api/trades/symbol/{symbol}
             GET Average Price of a specific stock : api/trades/symbol/{symbol}/average-price
             GET Total Volume of a specific stock trades : api/trades/symbol/{symbol}/volume
             GET Get NEt Profit_loss of a specific stock : api/trades/symbol/{symbol}/profit-loss

# Accessing Swagger 
 Access swagger UI using http://localhost:8080/swagger-ui.html

 # File Structure Information
 /Applicaition.java : Main Code
# repository
 /respsitory/TradeRespository.java : Class to fetch data from the database.
 /repository/TradeRowMapper.java : Utility class to convert SQl result into Trade Object

 # Model
 model/trade.java : class used to represent each row in the trades able

 # service: Handle API Requests
 service/TradeService.java : This class functions to get API requests from the controller and resolve the request ith relevent data as return parameter

 # Controller
 controller/TAMController.java: This class handles incomming HTTP requests and returns JSON data.
 



