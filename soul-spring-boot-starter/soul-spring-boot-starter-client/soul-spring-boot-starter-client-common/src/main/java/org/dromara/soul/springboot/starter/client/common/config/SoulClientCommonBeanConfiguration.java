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

package org.dromara.soul.springboot.starter.client.common.config;

import org.dromara.soul.client.core.register.SoulClientRegisterRepositoryFactory;
import org.dromara.soul.register.client.api.SoulClientRegisterRepository;
import org.dromara.soul.register.common.config.SoulRegisterCenterConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Soul client common bean configuration.
 * 
 * @author xiaoyu
 */
@Configuration
public class SoulClientCommonBeanConfiguration {
    
    /**
     * Register the register repository for http client bean post processor.
     *
     * @param config the config
     * @return the client register repository
     */
    @Bean
    public SoulClientRegisterRepository soulClientRegisterRepository(final SoulRegisterCenterConfig config) {
        return SoulClientRegisterRepositoryFactory.newInstance(config);
    }
    
    /**
     * Soul Register Center Config.
     *
     *
     * soul client 注册中心 相关的配置
     *
     * @return the Register Center Config
     */
    @Bean
    @ConfigurationProperties(prefix = "soul.client")
    public SoulRegisterCenterConfig soulRegisterCenterConfig() {
        return new SoulRegisterCenterConfig();
    }
}
