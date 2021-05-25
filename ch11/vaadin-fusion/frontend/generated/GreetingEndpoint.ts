/**
 * This module is generated from GreetingEndpoint.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///Users/alejandro/Documents/Apress/practical-vaadin/code/ch11/vaadin-fusion/src/main/java/com/apress/practicalvaadin/ch11/GreetingEndpoint.java}
 * @module GreetingEndpoint
 */

// @ts-ignore
import client from './connect-client.default';

function _greeting(
 name: string
): Promise<string> {
 return client.call('GreetingEndpoint', 'greeting', {name});
}
export {_greeting as greeting};
