package dr.edu.fatecfranca.api.dtos;

public record LoginResponse(
   String token,
   UserResponse user
) {}

