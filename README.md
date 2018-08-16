# warehouse-stock-manager




This project consist of three modules.
  #1) rest-service-warehouse-stock-manager
      This is a spring boot RESTful web service that also makes use of spring boot security.
      This project generates a JSON file by using the SWAGGER-UI plugin.
      The JSON file can then be converted to a YAML file which is consumed by the api-warehouse-stock-manager 
      using the SWAGGER-CODEGEN plugin.
      
    #2) api-warehouse-stock-manager
        This is a spring boot project that gets packaged into a jar to be added to the client-warehouse-stock-manager as 
        a dependency.
        This project provides the api functionality to the rest-service-warehouse-stock-manager.
        The api code gets generated from the YAML file which was created by the rest-service-warehouse-stock-manager JSON file using the
        SWAGGER-UI and SWAGGER-CODEGEN plugins.
        The project also makes use of MAPSTRUCT to map objects from the independent api level to the api translation level(consumed level).
        
    #3) client-warehouse-stock-manager
        This is the client that consumes the api-warehouse-stock-manager to be able to use the functionality of the 
        rest-service-warehouse-stock-manager.
