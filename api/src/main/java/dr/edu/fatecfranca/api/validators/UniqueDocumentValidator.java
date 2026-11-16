package dr.edu.fatecfranca.api.validators;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import dr.edu.fatecfranca.api.dtos.CustomerRequest;
import dr.edu.fatecfranca.api.repositories.CustomerRepository;

public class UniqueDocumentValidator extends RequestValidator<CustomerRequest> {

   private final CustomerRepository repository;

   public UniqueDocumentValidator(CustomerRepository repository,
                                  RequestValidator<CustomerRequest> next) {
       super(next);
       this.repository = repository;
   }

   @Override
   protected void check(CustomerRequest request, Long customerId) {
       String document = request.identDocument();
       boolean alreadyExists;


       if (customerId == null) {
           alreadyExists = repository.existsByIdentDocument(document);
       } else {
           alreadyExists = repository.existsByIdentDocumentAndIdNot(
               document, customerId
           );
       }

       if (alreadyExists) {
           throw new ResponseStatusException(
               HttpStatus.CONFLICT,
               "O documento informado já está cadastrado."
           );
       }
   }
}

