// **********************************************************************
//
// Copyright (c) 2001
// MutableRealms, Inc.
// Huntsville, AL, USA
//
// All Rights Reserved
//
// **********************************************************************

#include <IceUtil/IceUtil.h>

#include <TestBase.h>

using namespace std;

TestFailed::TestFailed(const std::string& n) :
    name(n)
{
}

TestBase::TestBase(const std::string& n) :
    _name(n)
{
}

string
TestBase::name() const
{
    return _name;
}

void
TestBase::start()
{
    cout << "running " << _name << " test... " << flush;
    try
    {
	run();
    }
    catch(const IceUtil::Exception& e)
    {
	cout << e << " failed" << endl;
	throw TestFailed(_name);
    }
    cout << "ok" << endl;
}
