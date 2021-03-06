
package org.mule.modules.pokemoninfo.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.pokemoninfo.PokemonInfoConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>PokemonInfoConnectorProcessAdapter</code> is a wrapper around {@link PokemonInfoConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-03T02:40:27-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class PokemonInfoConnectorProcessAdapter
    extends PokemonInfoConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<PokemonInfoConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, PokemonInfoConnectorCapabilitiesAdapter> getProcessTemplate() {
        final PokemonInfoConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,PokemonInfoConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, PokemonInfoConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, PokemonInfoConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
