package dr.edu.fatecfranca.api.validators;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import dr.edu.fatecfranca.api.dtos.CustomerRequest;
import dr.edu.fatecfranca.api.repositories.CustomerRepository;

public class UniqueEmailValidator extends RequestValidator<CustomerRequest> {

   private final CustomerRepository repository;

   public UniqueEmailValidator(CustomerRepository repository,
                               RequestValidator<CustomerRequest> next) {
       super(next);
       this.repository = repository;
   }

   @Override
   protected void check(CustomerRequest request, Long customerId) {
       String email = request.email();
       boolean alreadyExists;

       if (customerId == null) {
           alreadyExists = repository.existsByEmail(email);
       } else {
           alreadyExists = repository.existsByEmailAndIdNot(email, customerId);
       }

       if (alreadyExists) {
           throw new ResponseStatusException(
               HttpStatus.CONFLICT,
               "O e-mail informado já está cadastrado."
           );
       }
   }
}

