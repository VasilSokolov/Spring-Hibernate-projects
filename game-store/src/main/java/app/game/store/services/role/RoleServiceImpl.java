package app.game.store.services.role;

import app.game.store.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private final RoleRepository rolerepository;

	@Autowired
	public RoleServiceImpl(RoleRepository rolerepository) { 
		this.rolerepository = rolerepository;
	}

}