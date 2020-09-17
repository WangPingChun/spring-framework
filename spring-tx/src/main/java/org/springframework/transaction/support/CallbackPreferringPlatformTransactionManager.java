/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.transaction.support;

import org.springframework.lang.Nullable;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;

/**
 * 扩展自 PlatformTransactionManager。
 * 相当于是把事务的创建、提交和回滚操作都封装起来了，用于只需要传入 TransactionCallback 接口实例即可，
 * 而不是像使用 PlatformTransactionManager 接口那样，还需要用户自己显式调用 getTransaction、rollback、
 * commit 进行事务管理
 * Extension of the {@link org.springframework.transaction.PlatformTransactionManager}
 * interface, exposing a method for executing a given callback within a transaction.
 *
 * <p>Implementors of this interface automatically express a preference for
 * callbacks over programmatic {@code getTransaction}, {@code commit}
 * and {@code rollback} calls. Calling code may check whether a given
 * transaction manager implements this interface to choose to prepare a
 * callback instead of explicit transaction demarcation control.
 *
 * <p>Spring's {@link TransactionTemplate} and
 * {@link org.springframework.transaction.interceptor.TransactionInterceptor}
 * detect and use this PlatformTransactionManager variant automatically.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see TransactionTemplate
 * @see org.springframework.transaction.interceptor.TransactionInterceptor
 */
public interface CallbackPreferringPlatformTransactionManager extends PlatformTransactionManager {

	/**
	 * Execute the action specified by the given callback object within a transaction.
	 * <p>Allows for returning a result object created within the transaction, that is,
	 * a domain object or a collection of domain objects. A RuntimeException thrown
	 * by the callback is treated as a fatal exception that enforces a rollback.
	 * Such an exception gets propagated to the caller of the template.
	 * @param definition the definition for the transaction to wrap the callback in
	 * @param callback the callback object that specifies the transactional action
	 * @return a result object returned by the callback, or {@code null} if none
	 * @throws TransactionException in case of initialization, rollback, or system errors
	 * @throws RuntimeException if thrown by the TransactionCallback
	 */
	@Nullable
	<T> T execute(@Nullable TransactionDefinition definition, TransactionCallback<T> callback)
			throws TransactionException;

}
