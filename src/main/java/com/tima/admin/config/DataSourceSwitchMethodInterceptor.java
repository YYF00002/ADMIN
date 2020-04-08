package com.tima.admin.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Objects;


/**
 * @author zwh
 *
 */
public class DataSourceSwitchMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke ( MethodInvocation invocation ) throws Throwable {
        final String packageName = invocation.getThis().getClass().getPackage().getName();
        if ( packageName.contains( "admin" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.ADMIN_DATA_SOURCE_KEY);
        }
      /*  if ( packageName.contains( "vehicleModule" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.VEHICLE_DATA_SOURCE_KEY );
        }
        if ( packageName.contains( "hubModule" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.HUB_DATA_SOURCE_KEY );
        }
        if ( packageName.contains( "rcsModule" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.RCS_DATA_SOURCE_KEY );
        }
        if ( packageName.contains( "filestorageModule" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.FILESTORAGE_DATA_SOURCE_KEY );
        }
        if ( packageName.contains( "operationModule" ) ) {
            setDataSourceKey( invocation.getMethod() , GlobalConstant.OPERATION_DATA_SOURCE_KEY );
        }*/
        return invocation.proceed();
    }


    /**
     * 设置数据源key
     */
    private void setDataSourceKey ( final Method method , final String defaultKey ) {
        final DynamicDataSource dynamicDataSource = method.getAnnotation( DynamicDataSource.class );
        if ( Objects.isNull( dynamicDataSource ) ) {
            DynamicMultipleDataSource.setDataSourceKey( defaultKey );
            return;
        }
        DynamicMultipleDataSource.setDataSourceKey( dynamicDataSource.value() );
    }


}
