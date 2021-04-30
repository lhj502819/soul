/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.springboot.starter.client.springmvc;

import org.dromara.soul.client.springmvc.init.ContextRegisterListener;
import org.dromara.soul.client.springmvc.init.SpringMvcClientBeanPostProcessor;
import org.dromara.soul.register.client.api.SoulClientRegisterRepository;
import org.dromara.soul.register.common.config.SoulRegisterCenterConfig;
import org.dromara.soul.springboot.starter.client.common.config.SoulClientCommonBeanConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Soul client http configuration.
 *
 * @author xiaoyu
 */
@Configuration
//通过ImportAutoConfiguration指定装配SoulClientCommonBeanConfiguration
//SoulClientCommonBeanConfiguration是soul-spring-boot-starter-client-common工程下的类，说明该类是提供给所有的SoulClient Starter的
//  通过查看pom.xml文件也可以看到，所有的starter都依赖了soul-spring-boot-starter-client-common工程
@ImportAutoConfiguration(SoulClientCommonBeanConfiguration.class)
public class SoulSpringMvcClientConfiguration {
    
    /**
     * Spring http client bean post processor .
     *
     * @param config the config
     * @param soulClientRegisterRepository the client register repository
     * @return the spring http client bean post processor
     */
    @Bean
    public SpringMvcClientBeanPostProcessor springHttpClientBeanPostProcessor(final SoulRegisterCenterConfig config, final SoulClientRegisterRepository soulClientRegisterRepository) {
        return new SpringMvcClientBeanPostProcessor(config, soulClientRegisterRepository);
    }
    
    /**
     * Context register listener context register listener.
     *
     * @param config the config
     * @param soulClientRegisterRepository the client register repository
     * @return the context register listener
     */
    @Bean
    public ContextRegisterListener contextRegisterListener(final SoulRegisterCenterConfig config, final SoulClientRegisterRepository soulClientRegisterRepository) {
        return new ContextRegisterListener(config, soulClientRegisterRepository);
    }
    
}
