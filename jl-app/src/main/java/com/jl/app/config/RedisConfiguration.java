//package com.jl.app.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * springboot-redis配置
// * @author kz
// * @date 2022/1/18.
// */
//@AutoConfiguration
//public class RedisConfiguration {
//
////    /** redis密码 */
////    @Value("${spring.redis.password}")
////    private String password;
////
////    /** 使用库 */
////    @Value("${spring.redis.database}")
////    private int    database;
////
////    /** 连接超时时间（毫秒） */
////    @Value("${spring.redis.timeout}")
////    private int    timeout;
////
////    /** 连接池中的最大空闲连接 */
////    @Value("${spring.redis.pool.max-idle}")
////    private int    maxIdle;
////
////    /** 连接池中的最小空闲连接 */
////    @Value("${spring.redis.pool.min-idle}")
////    private int    minIdle;
////
////    /** 连接池最大连接数 */
////    @Value("${spring.redis.pool.max-active}")
////    private int    maxActive;
////
////    /** 连接池最大阻塞等待时间 */
////    @Value("${spring.redis.pool.max-wait}")
////    private int    maxWait;
////
////    /** 哨兵检测的master */
////    @Value("${spring.redis.sentinel.master}")
////    private String master;
////
////    /** 哨兵集群配置 */
////    @Value("${spring.redis.sentinel.nodes}")
////    private String redisNodes;
////
////   /**
////     * redis连接工厂
////     * @return redis连接工厂（使用lettuce）
////     * Created by kz on 2022/1/18 14:10.
////     */
////    @Bean
////    public LettuceConnectionFactory lettuceConnectionFactory() {
////        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
////        genericObjectPoolConfig.setMaxIdle(maxIdle);//最大空闲连接
////        genericObjectPoolConfig.setMinIdle(minIdle);//最小空闲连接
////        genericObjectPoolConfig.setMaxTotal(maxActive);//连接池最大连接数
////        genericObjectPoolConfig.setMaxWaitMillis(maxWait);//连接池最大阻塞等待时间
////        genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(100);//每隔多少毫秒，空闲线程驱逐器关闭多余的空闲连接，且保持最少空闲连接可用
////
////        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
////        redisStandaloneConfiguration.setDatabase(database);//使用库
////        String[] item = redisNodes.split(":");
////        redisStandaloneConfiguration.setHostName(item[0]);//IP
////        redisStandaloneConfiguration.setPort(Integer.parseInt(item[1]));//端口
////        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));//密码
////        LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
////                .commandTimeout(Duration.ofMillis(timeout))//连接超时时间
////                //.shutdownTimeout(Duration.ofMillis(shutDownTimeout))//在关闭客户端连接之前等待任务处理完成的最长时间，在这之后，无论任务是否执行完成，都会被执行器关闭，默认100ms
////                .poolConfig(genericObjectPoolConfig)
////                .build();
////
////        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfig);
////        factory.setShareNativeConnection(true);//允许多个连接共用一个物理连接；如果设置为false,会导致性能下降
////        factory.setValidateConnection(false);//每次获取连接时，校验连接是否可用。 默认情况下是不会校验连接是否可用的。如果设置true,会导致性能下降。
////        return factory;
////    }
//
//    /**
//     * RedisTemplate配置，key使用string序列化器，RedisTemplate配置，key使用string序列化器，value序列化使用JdkSerializationRedisSerializer
//     * @return RedisTemplate
//     **/
////    @Bean
////    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
////        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
////        redisTemplate.setConnectionFactory(redisConnectionFactory);
////        StringRedisSerializer stringSerializer = new StringRedisSerializer();
////        redisTemplate.setKeySerializer(stringSerializer); // key序列化
////        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value序列化
////        redisTemplate.setHashKeySerializer(stringSerializer); // Hash key序列化
////        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer()); // Hash value序列化
////        redisTemplate.afterPropertiesSet();
////        return redisTemplate;
////    }
//
//    /**
//     * RedisTemplate配置，key使用string序列化器，value序列化使用JdkSerializationRedisSerializer
//     * @return RedisTemplate
//     **/
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer); // key序列化
//        redisTemplate.setValueSerializer(redisSerializer); // value序列化
//        redisTemplate.setHashKeySerializer(stringSerializer); // Hash key序列化
//        redisTemplate.setHashValueSerializer(redisSerializer); // Hash value序列化
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    /**
//     * redis生成key
//     * springCache结合redis，@Cacheable key为空，需要下面这个方法，不然报错
//     * @return KeyGenerator key生成类
//     * Created by kz on 2019/2/25 16:15.
//     */
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... objects) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//
//    /**
//     * 配置使用的RedisCacheManager
//     * @param lettuceConnectionFactory lettuce连接工厂
//     * @return 平台自定义的RedisCacheManager
//     */
//    @Bean
//    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();  // 生成一个默认配置，通过config对象即可对缓存进行自定义配置
//        config = config.entryTtl(Duration.ofHours(8))     // 设置缓存的默认过期时间，也是使用Duration设置
//                .computePrefixWith(cacheName -> cacheName + ":");   //设置Cache的前缀，默认::
//                //.disableCachingNullValues();     // 不缓存空值（注释掉，允许缓存空值）
//
////        // 设置一个初始化的缓存空间set集合
////        Set<String> cacheNames = new HashSet<>();
////        cacheNames.add(RedisKeyConstant.SHIRO_SESSION_CACHE_KEY);
////        cacheNames.add(RedisKeyConstant.SHIRO_AUTHEN_UPR_CACHE_KEY);
////        cacheNames.add(RedisKeyConstant.SHIRO_AUTHEN_OCR_CACHE_KEY);
////        cacheNames.add(RedisKeyConstant.SHIRO_AUTHOR_CACHE_KEY);
////
////        // 对每个缓存空间应用不同的配置
////        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
////        configMap.put(RedisKeyConstant.SHIRO_SESSION_CACHE_KEY, config.entryTtl(Duration.ofHours(1)));
////        configMap.put(RedisKeyConstant.SHIRO_AUTHEN_UPR_CACHE_KEY, config.entryTtl(Duration.ofHours(1)));
////        configMap.put(RedisKeyConstant.SHIRO_AUTHEN_OCR_CACHE_KEY, config.entryTtl(Duration.ofHours(1)));
////        configMap.put(RedisKeyConstant.SHIRO_AUTHOR_CACHE_KEY, config.entryTtl(Duration.ofHours(1)));
//
//        return RedisCacheManager.builder(lettuceConnectionFactory)     // 使用自定义的缓存配置初始化一个cacheManager
//                .transactionAware()   //Cache的事务支持
//                .cacheDefaults(config)    //缓存默认配置
////                .initialCacheNames(cacheNames)  // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
////                .withInitialCacheConfigurations(configMap)      //自定义配置
//                .build();
//    }
//}
