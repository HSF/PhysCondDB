# coding: utf-8

"""
Copyright 2015 SmartBear Software

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    Ref: https://github.com/swagger-api/swagger-codegen
"""

from pprint import pformat
from six import iteritems


class SwaggerPayloadCollection(object):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    """
    def __init__(self):
        """
        SwaggerPayloadCollection - a model defined in Swagger

        :param dict swaggerTypes: The key is attribute name
                                  and the value is attribute type.
        :param dict attributeMap: The key is attribute name
                                  and the value is json key in definition.
        """
        self.swagger_types = {
            'offset': 'int',
            'limit': 'int',
            'items': 'list[Payload]'
        }

        self.attribute_map = {
            'offset': 'offset',
            'limit': 'limit',
            'items': 'items'
        }

        self._offset = None
        self._limit = None
        self._items = None

    @property
    def offset(self):
        """
        Gets the offset of this SwaggerPayloadCollection.


        :return: The offset of this SwaggerPayloadCollection.
        :rtype: int
        """
        return self._offset

    @offset.setter
    def offset(self, offset):
        """
        Sets the offset of this SwaggerPayloadCollection.


        :param offset: The offset of this SwaggerPayloadCollection.
        :type: int
        """
        self._offset = offset

    @property
    def limit(self):
        """
        Gets the limit of this SwaggerPayloadCollection.


        :return: The limit of this SwaggerPayloadCollection.
        :rtype: int
        """
        return self._limit

    @limit.setter
    def limit(self, limit):
        """
        Sets the limit of this SwaggerPayloadCollection.


        :param limit: The limit of this SwaggerPayloadCollection.
        :type: int
        """
        self._limit = limit

    @property
    def items(self):
        """
        Gets the items of this SwaggerPayloadCollection.


        :return: The items of this SwaggerPayloadCollection.
        :rtype: list[Payload]
        """
        return self._items

    @items.setter
    def items(self, items):
        """
        Sets the items of this SwaggerPayloadCollection.


        :param items: The items of this SwaggerPayloadCollection.
        :type: list[Payload]
        """
        self._items = items

    def to_dict(self):
        """
        Returns the model properties as a dict
        """
        result = {}

        for attr, _ in iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            else:
                result[attr] = value

        return result

    def to_str(self):
        """
        Returns the string representation of the model
        """
        return pformat(self.to_dict())

    def __repr__(self):
        """
        For `print` and `pprint`
        """
        return self.to_str()
