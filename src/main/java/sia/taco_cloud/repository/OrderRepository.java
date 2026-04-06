package sia.taco_cloud.repository;

import sia.taco_cloud.domain.TacoOrder;

public interface OrderRepository {
    public TacoOrder save(TacoOrder tacoOrder);
}
