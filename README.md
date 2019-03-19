# feature-toogle

Projeto demonstrativo de configuração de Feature toggle Java 8 com Spring Boot.

Adicione a dependência.

Obs: Segunda dependência e para a console de ADMIN, onde podemos desligar ou ligar uma funcionalidade.

```
<!-- Dependencia de toggle -->
<dependency>
	<groupId>org.togglz</groupId>
	<artifactId>togglz-spring-boot-starter</artifactId>
	<version>2.6.1.Final</version>
</dependency>

<!-- Togglz Admin Console (optional) -->
<dependency>
	<groupId>org.togglz</groupId>
	<artifactId>togglz-console</artifactId>
	<version>2.6.1.Final</version>
</dependency>
```

Crie um enum extendendo a interface Feture.

```
package br.com.toggle.api.enums;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum Funcionalidade implements Feature {

	@Label("Habilita mostrar sobre nome pessoa")
	HABILITA_SOBRE_NOME;

	public boolean isActive() {
		return FeatureContext.getFeatureManager().isActive(this);
	}
}
```

Crei um simple endpoint para testarmos nossa toggle.

```
@RestController
public class StatusController {
	
	@GetMapping("/recuperar/nome")
	public ResponseEntity<String> isToggleLigada() {
		
		StringBuilder sb = new StringBuilder("Adilson");
		
		if(Funcionalidade.HABILITA_SOBRE_NOME.isActive()) {
			sb.append(" Rodrigues da Silva");
		}
		
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}
}
```
Quando a toggle estiver ligada, irá trazer o nome completo, caso contrario, trará apenas o primeiro nome.

Console de Admin, para ligar ou desligar funcionalidades: http://localhost:8080/toggles/index. Acesse a console e desligue ou lige a toggle, e consuma a URL abaixo para ver o resultado.

Chamada GET: http://localhost:8080/recuperar/nome

Quando a toggle estiver ligada, apresenta meu nome completo "Adilson Rodrigues da Silva", quando desligada apresenta somente meu primeiro nome "Adilson"


