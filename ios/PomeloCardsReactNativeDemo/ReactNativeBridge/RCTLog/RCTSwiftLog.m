//
//  RCTSwiftLog.m
//  PomeloCardsReactNativeDemo
//
//  Created by Fernando Pena on 07/03/2023.
//

#import <Foundation/Foundation.h>
#import <React/RCTLog.h>
#import "RCTSwiftLog.h"

@implementation RCTSwiftLog

+ (void)info:(NSString *)message file:(NSString *)file line:(NSUInteger)line
{
  _RCTLogNativeInternal(RCTLogLevelInfo, file.UTF8String, (int)line, @"%@", message);
}

+ (void)warn:(NSString *)message file:(NSString *)file line:(NSUInteger)line
{
  _RCTLogNativeInternal(RCTLogLevelWarning, file.UTF8String, (int)line, @"%@", message);
}

+ (void)error:(NSString *)message file:(NSString *)file line:(NSUInteger)line
{
  _RCTLogNativeInternal(RCTLogLevelError, file.UTF8String, (int)line, @"%@", message);
}

+ (void)log:(NSString *)message file:(NSString *)file line:(NSUInteger)line
{
  _RCTLogNativeInternal(RCTLogLevelInfo, file.UTF8String, (int)line, @"%@", message);
}

+ (void)trace:(NSString *)message file:(NSString *)file line:(NSUInteger)line
{
  _RCTLogNativeInternal(RCTLogLevelTrace, file.UTF8String, (int)line, @"%@", message);
}

@end
