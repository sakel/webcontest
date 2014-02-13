package org.zabica.webcontest.stripes.beans;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;

@Intercepts(LifecycleStage.BindingAndValidation)
public class LoginInterceptor implements Interceptor {

	@Override
	public Resolution intercept(ExecutionContext context) throws Exception {
		switch (context.getActionBeanContext().getEventName()) {
		case "login":
		case "doLogin":
		case "register":
		case "doRegister":
		case "users":
			return context.proceed();
		default: {
			if (((SessionActionBeanContext) context.getActionBeanContext()).getUser() == null) {
				return new ForwardResolution("/views/login.jsp");
			}
			return context.proceed();
		}
		}
	}

}
