/*
 *   Copyright 2009-2010 Joubin Houshyar
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *    
 *   http://www.apache.org/licenses/LICENSE-2.0
 *    
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jredis.cluster.models;

import org.jredis.cluster.ClusterModel;
import org.jredis.cluster.ClusterNodeSpec;
import org.jredis.cluster.ClusterSpec;
import org.jredis.ri.alphazero.connection.DefaultConnectionSpec;
import org.jredis.ri.alphazero.support.Log;
import org.jredis.ri.cluster.DefaultClusterNodeSpec;
import org.jredis.ri.cluster.DefaultClusterSpec;
import org.jredis.ri.cluster.model.BasicStaticHashCluster;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * [TODO: document me!]
 *
 * @author  joubin (alphazero@sensesay.net)
 * @date    Mar 31, 2010
 * 
 */

public class BasicStaticHashClusterTest extends StaticHashClusterProviderTestBase {

	// ------------------------------------------------------------------------
	// super overrides
	// ------------------------------------------------------------------------
	

	/* (non-Javadoc) @see org.jredis.cluster.ClusterModelProviderTestBase#newClusterModel(org.jredis.cluster.ClusterSpec) */
	@Override
	protected ClusterModel newClusterModel (ClusterSpec clusterSpec) {
		ClusterModel model = null;
		try {
			model = new BasicStaticHashCluster(clusterSpec);
		}
		catch (RuntimeException e){
			Log.error("NOTE: propagating error > " + e.getLocalizedMessage());
			throw e;
		}
		return model;
	}

	/* (non-Javadoc) @see org.jredis.cluster.ClusterModelProviderTestBase#newClusterSpec() */
	@Override
	protected ClusterSpec newClusterSpec () {
		ClusterSpec spec = new DefaultClusterSpec();
		for(int i=0; i<100; i++){
			ClusterNodeSpec node = new DefaultClusterNodeSpec(DefaultConnectionSpec.newSpec("localhost", 6379+i, 0, null));
			spec.addNode(node);
		}
		return spec;
	}
	
	// ------------------------------------------------------------------------
	// BasicStaticHashCluster specific tests
	// ------------------------------------------------------------------------
    @Test
    public void fooTest() {
    	Log.log("Foo test for BasicStaticHash");
    	assertTrue(true);
    }

}
